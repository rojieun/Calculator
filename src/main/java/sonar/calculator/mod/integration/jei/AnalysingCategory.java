package sonar.calculator.mod.integration.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sonar.calculator.mod.Calculator;
import sonar.core.integration.jei.IJEIHandler;
import sonar.core.integration.jei.JEICategoryV2;

public class AnalysingCategory extends JEICategoryV2 {

	private final IDrawable background;

	public AnalysingCategory(IGuiHelper guiHelper, IJEIHandler handler) {
		super(handler);
		ResourceLocation location = new ResourceLocation("calculator", "textures/gui/" + handler.getTextureName() + ".png");
		background = guiHelper.createDrawable(location, 75, 29, 26, 36);
	}

    @Override
    public String getModName() {
        return Calculator.name;
    }

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(0, false, 4, 4);
		stacks.set(0, ingredients.getOutputs(ItemStack.class).get(0));
	}
}