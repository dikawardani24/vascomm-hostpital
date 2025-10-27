package dika.vasscom.utils

import android.content.Context
import es.dmoral.toasty.Toasty

fun Context.showError(message: String) {
    Toasty.error(this, message)
        .show()
}

fun Context.showSuccess(message: String) {
    Toasty.success(this, message)
        .show()
}

fun Context.showInfo(message: String) {
    Toasty.info(this, message)
        .show()
}

fun Context.showWarning(message: String) {
    Toasty.warning(this, message)
        .show()
}
