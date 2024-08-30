package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.flexible.bottomsheet.material3.FlexibleBottomSheet
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.FlexibleSheetValue
import com.skydoves.flexible.core.rememberFlexibleBottomSheetState
import first.composeapp.generated.resources.Image3
import first.composeapp.generated.resources.Res
import first.composeapp.generated.resources.bottom_bar
import first.composeapp.generated.resources.ic_button
import first.composeapp.generated.resources.ic_house
import first.composeapp.generated.resources.ic_hover
import first.composeapp.generated.resources.ic_symbol
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen() {
    var isShowingBottomSheet by remember { mutableStateOf(true) }
    var currentSheetTarget by remember {
        mutableStateOf(FlexibleSheetValue.IntermediatelyExpanded)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(Res.drawable.Image3),
            contentDescription = "back"
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.padding(top = 50.dp))
            Weather()
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(Res.drawable.ic_house),
                contentScale = ContentScale.FillWidth,
                contentDescription = "house",
            )
//            Scaffold(
//                bottomBar = { BottomNavigationBar() }
//            ) {
//                BottomSheet(
//                    //modifier = Modifier.padding(paddingValues = it)
//                )
//            }
            BottomNavigationBar(isClickBottomSheet = {isShowingBottomSheet = !isShowingBottomSheet})
            if(isShowingBottomSheet) {
                BottomSheet(
                    onDismissRequest = { isShowingBottomSheet = false },
                    bottomSheetState = { currentSheetTarget = it },
                )
            }
            //BottomNavigationBar()
            //BottomSheet()
//            Box{
//                BottomNavigationBar()
//                BottomSheet()
//            }
//            ModalBottomSheetLayout(
//                sheetState = bottomSheetState,
//                sheetContent = {
//                    Text("dsdfsd")
//                }
//            ) {
//                //BottomNavigationBar()
//            }
//            if (isShowingBottomSheet) {
//                BottomSheet {
//                    isShowingBottomSheet = false
//                }
//            }
//            BottomBar(
//                isClickBottomSheet = { isShowingBottomSheet = !isShowingBottomSheet }
//            )
        }

    }
}

@Composable
private fun Weather() {
    Text(
        text = "Montreal",
        fontSize = 34.sp,
        color = Color.White,
    )
    Text(
        modifier = Modifier.padding(top = 12.dp),
        text = "19°",
        fontSize = 96.sp,
        color = Color.White,
    )
    Column(
        modifier = Modifier.padding(
            top = 12.dp,
            start = 6.dp,
            end = 6.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Mostly Clear",
            fontSize = 20.sp,
            color = Color(0xFFABAEC7),
        )
        Row {
            Text(
                text = "H:24°",
                fontSize = 20.sp,
                color = Color.White,
            )
            Text(
                text = "L:18°",
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BottomBar(
    isClickBottomSheet: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = painterResource(Res.drawable.bottom_bar),
            contentDescription = "bottom_bar",
            contentScale = ContentScale.FillWidth,
        )
        IconButton(
            onClick = {},
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
            IconButton(onClick = isClickBottomSheet) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(Res.drawable.ic_symbol),
                    contentDescription = "symbol"
                )
            }
        }
    }
}

@Composable
private fun BottomShee(
    onDismissRequest: () -> Unit
) {
    FlexibleBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = rememberFlexibleBottomSheetState(
            flexibleSheetSize = FlexibleSheetSize(
                fullyExpanded = 0.5f,
                intermediatelyExpanded = 0.3f,
                slightlyExpanded = 0.15f,
            ),
            isModal = false,
            skipSlightlyExpanded = false,
        ),
        containerColor = Color.Black
    ) {
        Text(
            text = "TEST"
        )
    }
}