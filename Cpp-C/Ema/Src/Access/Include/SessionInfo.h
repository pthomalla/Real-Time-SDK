/*|-----------------------------------------------------------------------------
 *|            This source code is provided under the Apache 2.0 license      --
 *|  and is provided AS IS with no warranty or guarantee of fit for purpose.  --
 *|                See the project's LICENSE.md for details.                  --
 *|           Copyright (C) 2020 Refinitiv. All rights reserved.              --
 *|-----------------------------------------------------------------------------
 */

#ifndef __thomsonreuters_ema_access_SessionInfo_h
#define __thomsonreuters_ema_access_SessionInfo_h

 /**
	 @class thomsonreuters::ema::access::SessionInfo SessionInfo.h "Access/Include/SessionInfo.h"
	 @brief SessionInfo provides session information when EMA throws OmmJsonConverterException.

	 \remark All methods in this class are \ref SingleThreaded.

	 @see OmmJsonConverterException
 */

#include "Access/Include/ChannelInformation.h"

namespace thomsonreuters {

namespace ema {

namespace access {

class EMA_ACCESS_API SessionInfo
{
public:

	/** Returns the Channel Information for this session
		@return the channel information for this session
	*/
	virtual const ChannelInformation& getChannelInformation() const = 0;
};

}

}

}

#endif // __thomsonreuters_ema_access_SessionInfo_h
