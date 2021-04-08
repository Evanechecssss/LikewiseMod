package com.evanko.likewise;

import com.evanko.likewise.proxy.CommonProxy;
import com.evanko.likewise.reference.ModInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "[1.12]", updateJSON = "https://github.com/Evanechecssss/LikewiseMod/blob/main/production/LikewiseMod.main/mcmod.info")
public class LikeWiseMod {
    @SidedProxy(clientSide = "com.evanko.likewise.proxy.ClientProxy",serverSide = "com.evanko.likewise.proxy.CommonProxy")
    public static CommonProxy proxy;
    private static Logger logger;
    @Mod.Instance(ModInfo.MODID)
    public static LikeWiseMod instance;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        logger = event.getModLog();
        logger.warn("Mod preInitialization :" + ModInfo.NAME);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
        logger.warn("Mod initialization :" + ModInfo.NAME);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
        logger.warn("Mod postInitialization :" + ModInfo.NAME);
    }
}
