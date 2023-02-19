package ru.app.uikit.toolbar

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import ru.app.uikit.R

@BindingMethods(
    BindingMethod(
        type = MyWalletToolbar::class,
        attribute = "app:rightActionClick",
        method = "setRightActionClickListener"
    ),
    BindingMethod(
        type = MyWalletToolbar::class,
        attribute = "app:leftActionClick",
        method = "setLeftActionClickListener"
    )
)
class MyWalletToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val leftIconView: AppCompatImageView
    private val rightIconView: AppCompatImageView
    private val leftTextView: TextView
    private val rightTextView: TextView
    private val titleTextView: TextView

    private var rightIconSrc: Drawable? = null
        set(value) {
            field = value
            if (value == null) {
                rightIconView.visibility = GONE
            } else {
                rightIconView.setImageDrawable(value)
                rightTextView.visibility = GONE
            }
        }

    var rightActionText: String? = null
        set(value) {
            field = value
            if (value == null) {
                rightTextView.visibility = GONE
            } else {
                rightTextView.text = value
                rightIconView.visibility = GONE
            }
        }

    var leftActionText: String? = null
        set(value) {
            field = value
            if (value == null) {
                leftTextView.visibility = GONE
            } else {
                leftTextView.text = value
                leftIconView.visibility = GONE
            }
        }

    var leftIconSrc: Drawable? = null
        set(value) {
            field = value
            if (value == null) {
                leftIconView.visibility = GONE
            } else {
                leftIconView.setImageDrawable(value)
                leftTextView.visibility = GONE
            }
        }

    var title: String? = null
        set(value) {
            field = value
            if (value == null) {
                titleTextView.text = ""
            } else {
                titleTextView.text = value
            }
        }

    fun setRightActionClickListener(listener: OnClickListener) {
        when {
            rightIconSrc != null -> {
                rightIconView.setOnClickListener(listener)
            }

            rightActionText != null -> {
                rightTextView.setOnClickListener(listener)
            }
        }
    }

    fun setLeftActionClickListener(listener: OnClickListener) {
        when {
            leftIconSrc != null -> {
                leftIconView.setOnClickListener(listener)
            }

            leftActionText != null -> {
                leftTextView.setOnClickListener(listener)
            }
        }
    }

    init {
        val root = inflate(context, R.layout.view_my_wallet_toolbar, this)

        leftIconView = root.findViewById(R.id.view_my_wallet_toolbar_left_icon)
        rightIconView = root.findViewById(R.id.view_my_wallet_toolbar_right_icon)
        leftTextView = root.findViewById(R.id.view_my_wallet_toolbar_left_text)
        rightTextView = root.findViewById(R.id.view_my_wallet_toolbar_right_text)
        titleTextView = root.findViewById(R.id.view_my_wallet_toolbar_title)

        context.obtainStyledAttributes(attrs, R.styleable.MyWalletToolbar, 0, 0).let {
            rightIconSrc = it.getDrawable(R.styleable.MyWalletToolbar_rightIconSrc)
            leftIconSrc = it.getDrawable(R.styleable.MyWalletToolbar_leftIconSrc)
            leftActionText = it.getString(R.styleable.MyWalletToolbar_leftText)
            rightActionText = it.getString(R.styleable.MyWalletToolbar_rightText)
            title = it.getString(R.styleable.MyWalletToolbar_title)

            it.recycle()
        }
    }
}