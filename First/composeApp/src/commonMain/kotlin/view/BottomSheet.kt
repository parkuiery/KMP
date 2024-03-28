package view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.skydoves.flexible.bottomsheet.material3.BottomSheetDefaults
import com.skydoves.flexible.bottomsheet.material3.FlexibleBottomSheet
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.FlexibleSheetValue
import com.skydoves.flexible.core.rememberFlexibleBottomSheetState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    bottomSheetState: (FlexibleSheetValue) -> Unit,
) {
//    ModalBottomSheetLayout(
//        sheetContent = { Text("sdfsdf\n\n\n\n\n\nddd") },
//        sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.HalfExpanded)
//    ) {
//
//    }
    var isShowingBottomSheet by remember { mutableStateOf(true) }

    var currentSheetTarget by remember {
        mutableStateOf(FlexibleSheetValue.IntermediatelyExpanded)
    }
    val scope = rememberCoroutineScope()
    val state = rememberFlexibleBottomSheetState(
        flexibleSheetSize = FlexibleSheetSize(
            fullyExpanded = 0.7f,
            intermediatelyExpanded = 0.35f,
            slightlyExpanded = 0.15f,
        ),
        isModal = false,
        skipSlightlyExpanded = false,
    )
//    val contentColor = Color(
//        colors = listOf(Color(0xFF3658B1),Color(0xFFC159EC)),
//        alpha = 0.8f,
//
//    )

    when(currentSheetTarget) {
        FlexibleSheetValue.Hidden -> bottomSheetState(FlexibleSheetValue.Hidden)
        FlexibleSheetValue.IntermediatelyExpanded -> bottomSheetState(FlexibleSheetValue.IntermediatelyExpanded)
        FlexibleSheetValue.FullyExpanded -> bottomSheetState(FlexibleSheetValue.FullyExpanded)
        FlexibleSheetValue.SlightlyExpanded -> bottomSheetState(FlexibleSheetValue.SlightlyExpanded)
    }

    scope.launch {
        state.show()
    }

    FlexibleBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = state,
        onTargetChanges = { sheetValue ->
            currentSheetTarget = sheetValue
        },
        containerColor = Color(0xFF48319D).copy(alpha = 0.8f)
    ) {
        var tabIndex by remember { mutableStateOf(0) }

        val tabs = listOf("Hourly Forecast", "Weekly Forecast")

        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        modifier = Modifier.background(Color(0xFF)),
                        text = { Text(title) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
            when (tabIndex) {
                0 -> HourlyScreen()
            }
        }
    }
}