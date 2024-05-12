package test.com.github.www.sls1005.scalabletext

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import test.com.github.www.sls1005.scalabletext.ui.theme.ScalableTextTheme

class InformationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScalableTextTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(
                            stringResource(id = R.string.title1),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            stringResource(id = R.string.text1),
                            fontSize = 20.sp,
                            lineHeight = 26.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                        val url = stringResource(id = R.string.url1)
                        Text(
                            url,
                            fontSize = 20.sp,
                            lineHeight = 26.sp,
                            color = Color(0xFF3792FA),
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                    startActivity(
                                        Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    )
                                }
                        )
                        Text(
                            stringResource(id = R.string.text2),
                            fontSize = 20.sp,
                            lineHeight = 26.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                        val title = stringResource(id = R.string.title2)
                        TextButton(
                            onClick = {
                                startActivity(
                                    Intent(this@InformationActivity, OssLicensesMenuActivity::class.java).apply {
                                        putExtra("title", title)
                                    }
                                )
                            }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(
                                stringResource(id = R.string.display_licenses), fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}