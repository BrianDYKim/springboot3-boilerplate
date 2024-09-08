package team.me.extension.json

import team.me.extension.objectMapper.GLOBAL_OBJECT_MAPPER

fun Any.toJson(): String = GLOBAL_OBJECT_MAPPER.writeValueAsString(this)
