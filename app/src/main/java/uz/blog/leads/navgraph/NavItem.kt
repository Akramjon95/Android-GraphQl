package uz.blog.leads.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person


sealed class NavItem{
    object Home:
        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)
    object Calls:
        Item(path = NavPath.CALLS.toString(), title = NavTitle.CALLS, icon = Icons.Default.Call )
    object Chat:
        Item(path = NavPath.CHAT.toString(), title = NavTitle.CHAT, icon = Icons.Default.MailOutline)
    object Leads:
        Item(path = NavPath.LEADS.toString(), title = NavTitle.LEADS, icon = Icons.Default.Person )
    object More:
        Item(path = NavPath.MORE.toString(), title = NavTitle.MORE, icon = Icons.Default.MoreVert )

    //////////////////////
//    object Home:
//        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)
//    object Calls:
//        Item(path = NavPath.CALLS.toString(), title = NavTitle.CALLS, icon = Icons.Default.Call )
//    object Chat:
//        Item(path = NavPath.CHAT.toString(), title = NavTitle.CHAT, icon = Icons.Default.MailOutline)
//    object Leads:
//        Item(path = NavPath.LEADS.toString(), title = NavTitle.LEADS, icon = Icons.Default.Person )
//    object More:
//        Item(path = NavPath.MORE.toString(), title = NavTitle.MORE, icon = Icons.Default.MoreVert )
}
