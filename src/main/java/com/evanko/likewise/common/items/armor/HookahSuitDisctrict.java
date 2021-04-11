package com.evanko.likewise.common.items.armor;

import com.evanko.likewise.utils.reference.ModCreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class HookahSuitDisctrict extends ItemArmor {
    public HookahSuitDisctrict(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName("likewise." + name);
        this.setCreativeTab(ModCreativeTabs.LIKEWISE);
    }
}
