package test.com.github.www.sls1005.scalabletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import test.com.github.www.sls1005.scalabletext.ui.theme.ScalableTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScalableTextTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val r = remember { FocusRequester() }
                    var t by remember { mutableStateOf("") }
                    var s by remember { mutableStateOf(40.sp) }
                    OutlinedTextField(
                        value = t,
                        onValueChange = { t = it },
                        textStyle = TextStyle(fontSize = s),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxSize().focusRequester(r).transformable(
                            rememberTransformableState { x, _, _ ->
                                s = (s * x).let {
                                    if (it < 10.sp) {
                                        10.sp
                                    } else {
                                        it
                                    }
                                }
                            }
                        )
                    )
                    LaunchedEffect(Unit) {
                        delay(5)
                        r.requestFocus()
                    }
                }
            }
        }
    }
}
