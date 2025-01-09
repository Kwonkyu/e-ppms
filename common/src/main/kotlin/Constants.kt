package partners.pms.common

import java.time.ZoneId
import java.time.ZonedDateTime

val ZONE_SEOUL: ZoneId = ZoneId.of("Asia/Seoul")
val getCurrentSeoulTime: () -> ZonedDateTime = { ZonedDateTime.now(ZONE_SEOUL) }
