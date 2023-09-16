package me.cael.capes.menu

import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.option.GameOptionsScreen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.option.GameOptions
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

open class MainMenu(parent: Screen, gameOptions: GameOptions) : GameOptionsScreen(parent, gameOptions, TranslatableText("options.capes.title")) {

    override fun init() {

        val buttonW = 100
        val offset = (buttonW / 2) + 5

        addDrawableChild(ButtonWidget(
            (width/2) - (buttonW / 2), 35,
            buttonW, 20,
            TranslatableText("options.capes.selector")
        ) {
            client!!.setScreen(SelectorMenu(parent, gameOptions))
        }).active = this !is SelectorMenu

        addDrawableChild(ButtonWidget(
            (width/2) - (buttonW + offset), 35,
            buttonW, 20,
            TranslatableText("options.capes.toggle")) {
            client!!.setScreen(ToggleMenu(parent, gameOptions))
        }).active = this !is ToggleMenu

        addDrawableChild(ButtonWidget(
            (width/2) + offset, 35,
            buttonW, 20,
            TranslatableText("options.capes.other")) {
            client!!.setScreen(OtherMenu(parent, gameOptions))
        }).active = this !is OtherMenu

    }

    override fun render(context: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        this.renderBackground(context)
        DrawableHelper.drawCenteredTextWithShadow(context, textRenderer, title.asOrderedText(), width / 2, 20, 16777215)
        super.render(context, mouseX, mouseY, delta)
    }
}