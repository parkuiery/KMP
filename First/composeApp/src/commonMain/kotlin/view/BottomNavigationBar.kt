package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import first.composeapp.generated.resources.Res
import first.composeapp.generated.resources.bottom_bar
import first.composeapp.generated.resources.ic_button
import first.composeapp.generated.resources.ic_hover
import first.composeapp.generated.resources.ic_symbol
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    isClickBottomSheet: () -> Unit,
    ) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.HalfExpanded)
    var bottomSheetContent by remember { mutableStateOf(null) }


//    BottomNavigation(
//    ) {
//        Image(
//            painter = painterResource(Res.drawable.bottom_bar),
//            contentDescription = "bottom_bar",
//            contentScale = ContentScale.FillWidth,
//        )
//    }


    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = painterResource(Res.drawable.bottom_bar),
            contentDescription = "bottom_bar",
            contentScale = ContentScale.FillWidth,
        )
        IconButton(
            onClick = isClickBottomSheet,
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(Res.drawable.ic_button),
                contentDescription = "plus",
            )
        }
        Row(
            modifier = Modifier
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 24.dp,
                )
                .fillMaxWidth()
        ) {
            IconButton(onClick = {}) {
                Image(
                    modifier = Modifier.size(46.dp),
                    painter = painterResource(Res.drawable.ic_hover),
                    contentDescription = "hover",
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { }) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(Res.drawable.ic_symbol),
                    contentDescription = "symbol"
                )
            }
        }
    }
}