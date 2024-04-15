package cm.ben.android.bazel.compose.example.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Greeting("world")
    }
  }
}

@Preview
@Composable
fun Greeting(name: String = "world") {
  var bitmapState by remember{ mutableStateOf<Bitmap?>(null) }
  val context = LocalContext.current

  LaunchedEffect(Unit) {
    bitmapState = BitmapFactory.decodeStream(context.assets.open("icon.png"))
  }


  if (null != bitmapState) {
    val bitmap = bitmapState!!.asImageBitmap()
    Image(
      bitmap = bitmap,
      "assetsImage",
      colorFilter = null
    )
  }


  Text(text = "Hello\n$name!", fontSize = 100.sp)
}
