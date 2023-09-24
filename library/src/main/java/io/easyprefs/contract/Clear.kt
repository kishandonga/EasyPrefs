package io.easyprefs.contract

interface Clear : Atomic {
    fun all(): Atomic
}