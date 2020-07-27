package io.easyprefs.error

class PrefsWriteContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.write(context)")

class PrefsReadContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.read(context)")

class PrefsEditContextException :
    Exception("Context not initialize yet use like Prefs.initializeApp(context) or Prefs.edit(context)")