package dev.hossain.android.research

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.hossain.android.research.databinding.ActivityMainBinding
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F4BB] (PERSONAL COMPUTER)
        private val WOMAN_TECHNOLOGIST = "\uD83D\uDC69\u200D\uD83D\uDCBB"

        // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F3A4] (MICROPHONE)
        private val WOMAN_SINGER = "\uD83D\uDC69\u200D\uD83C\uDFA4"

        @JvmField
        val EMOJI = WOMAN_TECHNOLOGIST + " " + WOMAN_SINGER
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // https://developer.android.com/guide/navigation/navigation-ui#create_a_toolbar
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.toolbar)

        binding.emojiText.setText(EMOJI)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Timber.d("Menu item selected: $item")
        val isHandled = item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        if (isHandled.not()) {
            when (item.itemId) {
                android.R.id.home -> {
                    navController.popBackStack()
                    return true
                }
            }
        }
        return isHandled
    }
}
