package uz.blog.leads.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.blog.leads.screens.CreateLeads
import uz.blog.leads.screens.tabs.CallsScreen
import uz.blog.leads.screens.tabs.ChatScreen
import uz.blog.leads.screens.tabs.HomeScreen
import uz.blog.leads.screens.tabs.LeadsScreen

@Composable
fun BottomNavigationScreen(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavItem.Leads.path ){
        composable(NavItem.Home.path){ HomeScreen(navController) }
        composable(NavItem.Calls.path){ CallsScreen(navController) }
        composable(NavItem.Chat.path){ ChatScreen(navController) }
        composable(NavItem.Leads.path){ LeadsScreen(navController) }
        composable(NavItem.More.path){ HomeScreen(navController) }

        composable(route = "leads"){
            LeadsScreen(navController = navController)
        }
        composable(route = "createLeads"){
            CreateLeads(navController = navController)
        }
    }
}