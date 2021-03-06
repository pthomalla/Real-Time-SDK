package com.thomsonreuters.upa.valueadd.domainrep.rdm.directory;

import com.thomsonreuters.upa.codec.CloseMsg;
import com.thomsonreuters.upa.codec.CodecFactory;
import com.thomsonreuters.upa.codec.CodecReturnCodes;
import com.thomsonreuters.upa.codec.DataTypes;
import com.thomsonreuters.upa.codec.DecodeIterator;
import com.thomsonreuters.upa.codec.EncodeIterator;
import com.thomsonreuters.upa.codec.Msg;
import com.thomsonreuters.upa.codec.MsgClasses;
import com.thomsonreuters.upa.rdm.DomainTypes;
import com.thomsonreuters.upa.valueadd.domainrep.rdm.MsgBaseImpl;

class DirectoryCloseImpl extends MsgBaseImpl
{
    public DirectoryCloseImpl()
    {
        super();
    }

    public void clear()
    {
        super.clear();
    }

    public int copy(DirectoryClose destCloseMsg)
    {
        assert (destCloseMsg != null) : "destCloseMsg must be non-null";
        destCloseMsg.streamId(streamId());
        return CodecReturnCodes.SUCCESS;
    }

    public int decode(DecodeIterator dIter, Msg msg)
    {
        clear();
        if (msg.msgClass() != MsgClasses.CLOSE)
            return CodecReturnCodes.FAILURE;
        
        streamId(msg.streamId());
        
        return CodecReturnCodes.SUCCESS;
    }
    
    public int encode(EncodeIterator encodeIter)
    {
        closeMsg.clear();

        closeMsg.msgClass(MsgClasses.CLOSE);
        closeMsg.streamId(streamId());
        closeMsg.domainType(DomainTypes.SOURCE);
        closeMsg.containerType(DataTypes.NO_DATA);
        return closeMsg.encode(encodeIter);
    }
    
    public String toString()
    {
        StringBuilder stringBuf = super.buildStringBuffer();
        stringBuf.insert(0, "DirectoryClose: \n");
        return stringBuf.toString();
    }
    
    @Override
    public int domainType()
    {
        return DomainTypes.SOURCE;
    }

    private CloseMsg closeMsg = (CloseMsg)CodecFactory.createMsg();
}