package uz.blog.leads.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.blog.leads.navgraph.NavItem
import uz.blog.leads.ui.theme.BgBottomNav
import uz.blog.leads.ui.theme.BgSelectedBtn
import uz.blog.leads.ui.theme.InActiveTextColor


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navHostController: NavHostController){
    val navItems = listOf(NavItem.Home, NavItem.Calls, NavItem.Chat, NavItem.Leads, NavItem.More)
    var selectedItem by rememberSaveable {
        mutableStateOf(3)
    }
 Scaffold {
     NavigationBar(
         modifier = Modifier
             .background(Color.White)
             .clip(RoundedCornerShape(15.dp))
     ) {
         Row(
             modifier = Modifier
                 .background(BgBottomNav)
                 .clip(RoundedCornerShape(15.dp))
         ) {

             navItems.forEachIndexed { index, item ->
                 NavigationBarItem(
                     selected = selectedItem == index,
                     icon = { Icon(item.icon, contentDescription = item.title) },
                     label = { Text(text = item.title, color = if (selectedItem == index) Color.White else InActiveTextColor) },
                     alwaysShowLabel = true,
                     onClick = {
                         selectedItem = index
                         navHostController.navigate(item.path) {
                             navHostController.graph.startDestinationRoute?.let { route ->
                                 popUpTo(route) { saveState = true }
                             }
                             launchSingleTop = true
                             restoreState = true
                         }
                     }
                 )
             }
         }
     }
 }
}