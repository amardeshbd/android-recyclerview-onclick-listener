package dev.hossain.android.research.experiments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import dev.hossain.android.research.R
import timber.log.Timber

abstract class ExperimentBaseFragment : Fragment() {

    /**
     * Called when user selects [R.id.menu_synopsis] from the tool bar.
     */
    abstract fun onSynopsisMenuClicked()

    /**
     * Called when user selects [R.id.menu_show_code] from the tool bar.
     */
    abstract fun onShowCodeClicked()

    //
    // Handle synopsis menu item for any example
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_common_synopsis, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_synopsis -> {
                Timber.d("User selected to see synopsis")
                onSynopsisMenuClicked()
                return true
            }
            R.id.menu_show_code -> {
                Timber.d("User selected to see source code")
                onShowCodeClicked()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
