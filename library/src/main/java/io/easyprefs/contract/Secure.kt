package io.easyprefs.contract

import io.easyprefs.contract.provider.HasPrefProvider
import io.easyprefs.contract.provider.ReadPrefProvider
import io.easyprefs.contract.provider.WritePrefProvider

interface Secure : WritePrefProvider, ReadPrefProvider, HasPrefProvider