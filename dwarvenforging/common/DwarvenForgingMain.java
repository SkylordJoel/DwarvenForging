package dwarvenforging.common;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=DwarvenForgingMain.modid, name="Dwarven Forging - A LOTR and TiCo Bridge", version="Beta 0.1", dependencies="required-after:LOTR;required-after:TConstruct")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class DwarvenForgingMain {
	
	public static CreativeTabs tabDF = new CreativeTabs("tabDF") {
		public ItemStack getIconItemstack() {
			return new ItemStack(replace);
		}
	};
	
	@SidedProxy(clientSide = "dwarvenforging.client.ClientProxy", serverSide = "dwarvenforging.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static final String modid = "DwarvenForging";
	
	@Instance("DwarvenForging")
	public static DwarvenForgingMain instance;
	
	//Blocks and Items Registry |
	public static Item replace;
	
	//ID Registry
	public static int replaceID;
	
	public void initConfiguration(FMLInitializationEvent event) {
		Configuration config = new Configuration(new File("config/AwesCorp/DwarvenForging.cfg"));
		config.load();
		
		replaceID = config.get("DISREGARD", "Disregard this", 5000).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHelper.log(Level.INFO, "Preinitialised successfully"); //about the preinitialiSed, I'm australian
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		this.initConfiguration(event);
		
		replace = new ItemBasic/*meta*/(this.replaceID).setUnlocalizedName("basicItem");
		
		gameRegisters();
		languageRegisters();
		craftingRecipes();
		smeltingRecipes();
		blockHarvest();
		registerOre();
		
		proxy.registerRenderers();
		
		LogHelper.log(Level.INFO, "Initialised successfully");
}

	public void registerOre() {
		//OreDictionary.registerOre(id, ore)
		
	}

	private void blockHarvest() {
		//MinecraftForge.setBlockHarvestLevel(block, toolClass, harvestLevel)
		
	}

	private void smeltingRecipes() {
		//GameRegistry.addSmelting(input, output, xp)
		
	}

	private void craftingRecipes() {
		//GameRegistry.addShapedRecipe(output, params)
		//GameRegistry.addShapelessRecipe(output, params)
		//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(output), params))
		//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(output), params))
		
	}

	private void languageRegisters() {
		//LanguageRegistry.addName(objectToName, name)
		LanguageRegistry.addName(replace, "Placeholder Item");
		
	}

	private void gameRegisters() {
		//GameRegistry.registerBlock(block, name)
		//GameRegistry.registerItem(item, name) (used only for non meta items)
		
	}
	
}
