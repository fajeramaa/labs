package com.example.lab72.ui.components




import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun StarRating(
    stars: Float,
    onStarsChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            RatingBar(context).apply {
                numStars = 5
                stepSize = 0.5f

                setOnRatingBarChangeListener { _, value, fromUser ->
                    if (fromUser) {
                        onStarsChange(value)
                    }
                }
            }
        },
        update = { view ->
            view.rating = stars
        },
        modifier = modifier
    )
}
