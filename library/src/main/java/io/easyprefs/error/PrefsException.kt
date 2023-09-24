package io.easyprefs.error

class PrefsWriteContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.write(context)")

class PrefsReadContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.read(context)")

class PrefsClearContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.clear(context)")

class PrefsRemoveContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.remove(context)")

class PrefsHasContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.has(context)")

class PrefsSecurelyContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.securely(context)")