package cue.edu.co.myapplication

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import cue.edu.co.myapplication.viewmodel.ProductViewModel

/**
 * Owns the ViewModelStore so one ProductViewModel is shared by every Activity
 * (a per-Activity ViewModel would give each screen its own, separate list).
 */
class ProductApp : Application(), ViewModelStoreOwner {
    override val viewModelStore = ViewModelStore()

    val productViewModel: ProductViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ProductViewModel::class.java]
    }
}
