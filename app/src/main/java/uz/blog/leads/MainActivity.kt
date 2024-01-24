package uz.blog.leads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import uz.blog.leads.navgraph.BottomNavigationScreen

import uz.blog.leads.screens.tabs.LeadsScreen
import uz.blog.leads.ui.theme.LeadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeadsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                   // LeadsScreen(navController)
                    BottomNavigationScreen(navController = navController)
                    //CreateLeads()
                    //LeadDetailsScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeadsTheme {
        val navController = rememberNavController()
        LeadsScreen(navController)
    }
}