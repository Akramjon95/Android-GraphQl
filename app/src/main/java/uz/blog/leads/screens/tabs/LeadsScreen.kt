package uz.blog.leads.screens.tabs

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.blog.leads.R
import uz.blog.leads.model.BottomMenuContent
import uz.blog.leads.model.LeadsItems
import uz.blog.leads.navgraph.BottomNavigationScreen
import uz.blog.leads.navgraph.Item
import uz.blog.leads.navgraph.NavItem
import uz.blog.leads.navgraph.NavPath
import uz.blog.leads.screens.BottomNavigationBar
import uz.blog.leads.ui.theme.BgBottomNav
import uz.blog.leads.ui.theme.BgSelectedBtn
import uz.blog.leads.ui.theme.BoxBgColor
import uz.blog.leads.ui.theme.InActiveTextColor
import uz.blog.leads.ui.theme.statusCustom
import uz.blog.leads.ui.theme.statusCustomText
import uz.blog.leads.ui.theme.statusNew
import uz.blog.leads.ui.theme.statusNewText


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LeadsScreen(navController: NavHostController) {

    val selectedItem = remember {
        mutableStateOf<LeadsItems?>(null)
    }
Scaffold(
    bottomBar = {
        BottomBar(navController = navController)
    }
)
{
    Box(modifier = Modifier
        .fillMaxWidth()
    ){
        Column {
            Toolbar(navController)
            LeadsContent(onLeadsItemClick = {item->
                selectedItem.value = item
            } )
        }
    }
 }
}


@Composable
fun Toolbar(navController: NavHostController){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Text(text = "Leads", fontSize = 24.sp)
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BoxBgColor)
                .padding(10.dp)
                .clickable { navController.navigate("createLeads") }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.add_user),
                    contentDescription = "Add",
                    modifier = Modifier.size(26.dp))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BoxBgColor)
                .padding(10.dp)
                .clickable { },
            ){
                Icon(
                    painter =  painterResource(id = R.drawable.search),
                    contentDescription = "Add",
                    modifier = Modifier.size(26.dp))
            }
        }

    }

}

val leadsList = listOf(
    LeadsItems("1","Akramjon", "Kuchkarov", "A", R.drawable.uz, "New"),
    LeadsItems("2","Test1", "TestTest", "A", R.drawable.us, "Unsuccessful"),
    LeadsItems("3","Test2", "TestTest", "B", R.drawable.uk, "Junk"),
    LeadsItems("4","Test3", "TestTest", "C", R.drawable.uz, "Customer"),
    LeadsItems("5","Test4", "TestTest", "D", R.drawable.us, "No Answer"),
    LeadsItems("6","Test5", "TestTest", "F", R.drawable.uk, "Option Sent"),
)

@Composable
fun LeadsContent(
    onLeadsItemClick: (LeadsItems) -> Unit
){
    LazyColumn{
        items(leadsList){ leads->
            LeadsItems(
                leadsItems = leads,
                onLeadsItemClick = onLeadsItemClick
            )
        }
    }
}

@Composable
fun LeadsItems(leadsItems: LeadsItems, onLeadsItemClick: (LeadsItems) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onLeadsItemClick(leadsItems) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Gray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = leadsItems.imageRes.toString(), fontSize = 18.sp)
        }
//        GlideImage(
//            modifier = Modifier
//                .width(50.dp)
//                .height(50.dp)
//                .clip(CircleShape),
//            imageModel = leadsItems.imageRes,
//            contentScale = ContentScale.Crop,
//            circularReveal = CircularReveal(duration = 250),
//            //placeHolder = ImageBitmap.imageResource(R.drawable.avater),
//        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = leadsItems.name, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(3.dp))
        Text(text = leadsItems.lastName, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(id = leadsItems.countryFlag),
            contentDescription = leadsItems.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
        )

        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (leadsItems.status == "New") statusNew else statusCustom)
                .padding(5.dp),
                contentAlignment = Alignment.CenterEnd
            ){
                Text(
                    text = leadsItems.status,
                    fontSize = 12.sp,
                    color = if (leadsItems.status == "New") statusNewText else statusCustomText)
            }
        }

    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screen = listOf(
        BottomMenuContent.Home,
        BottomMenuContent.Calls,
        BottomMenuContent.Chats,
        BottomMenuContent.Leads,
        BottomMenuContent.More
    )

    BottomMenu(items = screen,
        navController = navController,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .clip(RoundedCornerShape(10.dp))
    )

}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = BgSelectedBtn,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = InActiveTextColor,
    initialSelectedItemIndex: Int = 0,
    navController: NavHostController
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(BgBottomNav)
            .padding(15.dp)
    ) {
        items.forEachIndexed{index, items ->
            BottomMenuItem(item = items,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                currentDestination = currentDestination,
                navController = navController
            )
            //{
               // selectedItemIndex = index
           // }
        }
    }
}


@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = BgSelectedBtn,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = InActiveTextColor,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {  }
    ) {
        val selected = currentDestination?.hierarchy?.any{ it.route == item.route} == true
        val background =
            if (selected) activeHighlightColor else Color.Transparent
        val contentColor =
            if(selected) activeTextColor else inactiveTextColor
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(background)
                .padding(10.dp)
                .clickable(onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                })
        ){
            Icon(painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = contentColor,
                modifier = Modifier.size(20.dp))
        }
        Text(
            text = item.title,
            color = if (selected) activeTextColor else inactiveTextColor)
    }
}