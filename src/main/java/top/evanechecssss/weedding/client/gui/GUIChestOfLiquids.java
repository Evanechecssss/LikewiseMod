package top.evanechecssss.weedding.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import top.evanechecssss.weedding.common.containers.ContainerChestOfLiquids;
import top.evanechecssss.weedding.common.tileEntitys.ChestOfLiquidsTE;
import top.evanechecssss.weedding.network.capability.main.Addiction;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class GUIChestOfLiquids extends GuiContainer {

    private static final int HIGH = 185;
    private static final int WIDTH = 173;
    public ChestOfLiquidsTE te;
    private ResourceLocation texture = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/chest_of_liquids.png");
    EntityPlayer player;
    public GUIChestOfLiquids(ContainerChestOfLiquids inventorySlotsIn, ChestOfLiquidsTE te, EntityPlayer player) {
        super(inventorySlotsIn);
        this.te = te;
        xSize = WIDTH;
        ySize = HIGH;
        this.player = player;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (Addiction.get(player).getAddiction() >= 10) {
            this.texture = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/chest_of_liquids_p.png");
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        float randomX = 0;
        float randomY = 0;
        if (Addiction.get(player).getAddiction() >= 10) {
            randomX = (float) (Math.random() * 6);
            randomY = (float) (Math.random() * 6);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(randomX, randomY, 0);
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        GlStateManager.popMatrix();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
}