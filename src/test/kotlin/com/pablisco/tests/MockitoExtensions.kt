package com.pablisco.tests

import org.mockito.BDDMockito.*

inline fun <reified T> mock(noinline f: T.() -> Unit = {}): T =
    mock(T::class.java).apply(f)

inline fun <reified T> stub(noinline f: T.() -> Unit = {}): T =
    mock(T::class.java, withSettings().stubOnly()).apply(f)

infix fun <T> T.returns(t: T) {
    given(this).willReturn(t)
}

infix inline fun <T> T.throws(ef: () -> Throwable) {
    given(this).willThrow(ef())
}
