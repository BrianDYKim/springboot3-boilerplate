package team.me.extension.string

import team.me.extension.objectMapper.GLOBAL_OBJECT_MAPPER

fun <T> String.parseJson(type: Class<T>): T = GLOBAL_OBJECT_MAPPER.readValue(this, type)
