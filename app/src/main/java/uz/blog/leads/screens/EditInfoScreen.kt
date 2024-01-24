package uz.blog.leads.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.blog.leads.R
import uz.blog.leads.ui.theme.BoxBgColor
import uz.blog.leads.ui.theme.Purple40
import uz.blog.leads.ui.theme.saveBtnColor
import java.util.Locale


@Preview
@Composable
fun EditInfoScreen(){
    Column {
        ToolbarInfo()
        ContentInfo()
    }
}

@Composable
fun ToolbarInfo(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BoxBgColor)
            .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = "Add",
                modifier = Modifier.size(26.dp)
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Edit info", fontSize = 24.sp,)
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentInfo(){
    var name by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        val list = listOf("sda")
        items(list.size) {
            Text(
                text = "First name",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Name", color = Color.Gray) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                    //TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
                )
            }
            //
            Text(
                text = "Last name",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = { Text("Last name", color = Color.Gray) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                    // colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
                )
            }
            //
            Text(
                text = "Lead intention",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
            val listIntention = listOf("Buy", "Sell", "Rent", "Rent out")
            ExposedSelectionMenuInfo(title = "Select", options = listIntention)
            //
            Text(
                text = "AD Source",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
            val sourceList = listOf(
                "AdWorks",
                "Yandex",
                "Facebook",
                "Instagram",
                "Tik tok",
                "LinkedIn",
                "Twitter"
            )
            ExposedSelectionMenuInfo(title = "Select", options = sourceList)
            //
            Text(
                text = "Country ",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
            CountryListInfo()
            //
            Text(
                text = "Language ",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )

            val languageList = listOf("Afrikaans", "Arabic", "Uzbek")
            ExposedSelectionMenuInfo(title = "Select", options = languageList)

            //
            SaveItemsViewInfo()
        }

    }
}

@Composable
fun SaveItemsViewInfo(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(20.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(1.dp, color = saveBtnColor)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Cancel",
                    fontSize = 16.sp,
                    color = saveBtnColor
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(saveBtnColor)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Save", fontSize = 16.sp, color = Color.Black)
            }
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedSelectionMenuInfo(
    title: String,
    //index: Int,
    options: List<String>,
    //onSelected: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(vertical = 4.dp),
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            placeholder = { Text(title) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        ExposedDropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEachIndexed { index: Int, selectionOption: String ->
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                        //onSelected(index)
                    },
                    text = {
                        Text(text = selectionOption, fontSize = 18.sp)
                    }
                )
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryListInfo() {
    val searchText = rememberSaveable { mutableStateOf("") }
    val countries = getCountries() //remember { mutableStateOf(getCountries()) }
    var filteredCountries: ArrayList<String>

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth()
    ) {

        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .padding(vertical = 4.dp),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = {searchText.value = it },
                placeholder = { Text("Country") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )

            )
            ExposedDropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                countries.forEachIndexed { index: Int, selectionOption: String ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                            //onSelected(index)
                        },
                        text = {
                            Text(text = selectionOption, fontSize = 18.sp)
                        }
                    )
                }
            }
        }
        /////////////////////////////////////////////////
    }
}


@Composable
fun getCountriesInfo(): ArrayList<String> {
    val isoCountryCodes: Array<String> = Locale.getISOCountries()
    val countriesWithEmojis: ArrayList<String> = arrayListOf()
    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName: String = locale.displayCountry
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag =
            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
        countriesWithEmojis.add("$countryName (${locale.country} $flag")
    }
    return countriesWithEmojis
}