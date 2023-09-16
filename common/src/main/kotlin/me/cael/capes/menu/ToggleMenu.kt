package me.cael.capes.menu

import me.cael.capes.CapeType
import me.cael.capes.Capes
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ScreenTexts
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.option.GameOptions
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class ToggleMenu(parent: Screen, gameOptions: GameOptions) : MainMenu(parent, gameOptions) {

    override fun init() {
        super.init()

        val config = Capes.CONFIG

        addDrawableChild(ButtonWidget(
            width / 2 - 155, height / 7 + 24,
            150, 20,
            CapeType.OPTIFINE.getToggleText(config.enableOptifine)
        ) {
            config.enableOptifine = !config.enableOptifine
            config.save()
            it.message = CapeType.OPTIFINE.getToggleText(config.enableOptifine)
        })

        addDrawableChild(ButtonWidget(
            width / 2 - 155 + 160, height / 7 + 24,
            150, 20,
            CapeType.LABYMOD.getToggleText(config.enableLabyMod)
        ) {
            config.enableLabyMod = !config.enableLabyMod
            config.save()
            it.message = CapeType.LABYMOD.getToggleText(config.enableLabyMod)
        })

        addDrawableChild(ButtonWidget(
            width / 2 - 155, height / 7 + 2 * 24,
            150, 20,
            CapeType.MINECRAFTCAPES.getToggleText(config.enableMinecraftCapesMod)
        ) {
            config.enableMinecraftCapesMod = !config.enableMinecraftCapesMod
            config.save()
            it.message = CapeType.MINECRAFTCAPES.getToggleText(config.enableMinecraftCapesMod)
        })

        addDrawableChild(ButtonWidget(
            width / 2 - 155 + 160, height / 7 + 2 * 24,
            150, 20,
            CapeType.WYNNTILS.getToggleText(config.enableWynntils)
        ) {
            config.enableWynntils = !config.enableWynntils
            config.save()
            it.message = CapeType.WYNNTILS.getToggleText(config.enableWynntils)
        })

        addDrawableChild(ButtonWidget(
            width / 2 - 155, height / 7 + 3 * 24,
            150, 20,
            CapeType.COSMETICA.getToggleText(config.enableCosmetica)
        ) {
            config.enableCosmetica = !config.enableCosmetica
            config.save()
            it.message = CapeType.COSMETICA.getToggleText(config.enableCosmetica)
        })

        addDrawableChild(ButtonWidget(
            width / 2 - 155 + 160, height / 7 + 3 * 24,
            150, 20,
            CapeType.CLOAKSPLUS.getToggleText(config.enableCloaksPlus)
        ) {
            config.enableCloaksPlus = !config.enableCloaksPlus
            config.save()
            it.message = CapeType.CLOAKSPLUS.getToggleText(config.enableCloaksPlus)
        })

        addDrawableChild(ButtonWidget(
            (width/2) - (200 / 2), height / 7 + 4 * 24,
            200, 20,
            elytraMessage(config.enableElytraTexture)
        ) {
            config.enableElytraTexture = !config.enableElytraTexture
            config.save()
            it.message = elytraMessage(config.enableElytraTexture)
        })

        addDrawableChild(ButtonWidget(
            (width/2) - (200 / 2), height / 7 + 5 * 24,
            200, 20,
            ScreenTexts.DONE
        ) {
            client!!.setScreen(parent)
        })

    }

    private fun elytraMessage(enabled: Boolean) = ScreenTexts.composeToggleText(TranslatableText("options.capes.elytra"), enabled)

}