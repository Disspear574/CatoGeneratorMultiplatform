package cats.presentation

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.crossfade
import coil3.util.DebugLogger

fun newImageLoader(
    context: PlatformContext,
    debug: Boolean = false,
): ImageLoader {
    return ImageLoader.Builder(context)

        .crossfade(true)
        .apply {
            if (debug) {
                logger(DebugLogger())
            }
        }
        .build()
}