package lk.spacewa.boilerplate.utils

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import lk.spacewa.boilerplate.utils.RoundedImageView

/**
 * Created by Imdad on 05/11/20.
 */
class RoundedImageView : AppCompatImageView {
    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        try {
            val drawable = drawable ?: return
            if (width == 0 || height == 0) {
                return
            }
            val bitmap: Bitmap
            val w = width
            val h = height
            if (w <= 0 || h <= 0) {
                return
            }
            if (drawable is BitmapDrawable) {
                val b = drawable.bitmap
                bitmap = b.copy(Bitmap.Config.ARGB_8888, true)
            } else if (drawable is ColorDrawable) {
                bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
                val c = Canvas(bitmap)
                c.drawColor(drawable.color)
            } else {
                return
            }
            val roundBitmap = getRoundedCroppedBitmap(bitmap, Math.min(w, h))
            canvas.drawBitmap(roundBitmap, 0f, 0f, null)
        } catch (e: Exception) {
            Log.e(TAG, "onDraw Exception", e)
        }
    }

    private fun getRoundedCroppedBitmap(bitmap: Bitmap, radius: Int): Bitmap {
        val finalBitmap: Bitmap
        finalBitmap = if (bitmap.width != radius || bitmap.height != radius) {
            Bitmap.createScaledBitmap(bitmap, radius, radius, false)
        } else {
            bitmap
        }
        val output = Bitmap.createBitmap(finalBitmap.width,
                finalBitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val paint = Paint()
        val rect = Rect(0, 0, finalBitmap.width,
                finalBitmap.height)
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = Color.parseColor("#BAB399")
        canvas.drawCircle(finalBitmap.width / 2.toFloat(),
                finalBitmap.height / 2.toFloat(),
                finalBitmap.width / 2.toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(finalBitmap, rect, rect, paint)
        return output
    }

    companion object {
        private val TAG = RoundedImageView::class.java.simpleName
    }
}