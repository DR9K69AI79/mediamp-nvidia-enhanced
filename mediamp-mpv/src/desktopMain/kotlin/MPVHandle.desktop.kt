/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * Use of this source code is governed by the Apache License version 2 license, which can be found at the following link.
 *
 * https://github.com/open-ani/mediamp/blob/main/LICENSE
 */
@file:JvmName("MPVHandleDesktop")

package org.openani.mediamp.mpv

import org.openani.mediamp.InternalMediampApi

@InternalMediampApi
external fun nAttachDesktopSurface(ptr: Long, windowHandle: Long): Boolean

@InternalMediampApi
external fun nDetachDesktopSurface(ptr: Long): Boolean

@OptIn(InternalMediampApi::class)
internal actual fun attachSurface(ptr: Long, surface: Any): Boolean {
    check(surface is Long) { "surface must be a Long (HWND on Windows)" }
    return nAttachDesktopSurface(ptr, surface)
}

@OptIn(InternalMediampApi::class)
internal actual fun detachSurface(ptr: Long): Boolean {
    return nDetachDesktopSurface(ptr)
}