import net.eternalclient.api.accessors.GameObjects;
import net.eternalclient.api.accessors.LocalPlayer;
import net.eternalclient.api.events.EntityInteractEvent;
import net.eternalclient.api.frameworks.tree.Leaf;
import net.eternalclient.api.utilities.Log;
import net.eternalclient.api.utilities.MethodProvider;
import net.eternalclient.api.utilities.ReactionGenerator;
import net.eternalclient.api.wrappers.interactives.GameObject;
import net.eternalclient.api.wrappers.map.RectArea;

public class WoodcuttingLeaf extends Leaf {

    @Override
    public boolean isValid() {
        return LocalPlayer.get().isInArea(new RectArea(3200,3505,3224,3502));
    }

    @Override
    public int onLoop() {
        GameObject tree = GameObjects.closest(g -> g.hasName("Tree") && g.hasAction("Chop down"));
        if(Constants.currentLevel > 15 && Constants.currentLevel <= 30)
            tree = GameObjects.closest(g -> g.hasName("Oak tree") && g.hasAction("Chop down"));
        if(Constants.currentLevel > 30 && Constants.currentLevel <= 58)
            tree = GameObjects.closest(g -> g.hasName("Willow tree") && g.hasAction("Chop down"));
        if(Constants.currentLevel > 60) {
            tree = GameObjects.closest(g -> g.hasName("Yew tree") && g.hasAction("Chop down"));
            Log.info("ok");
        }
        if (tree == null) {
            MethodProvider.tickSleep(1);
            return ReactionGenerator.getLowPredictable();
        }
        if(!LocalPlayer.get().isAnimating()){
            new EntityInteractEvent(tree, "Chop down")
                    .setEventCompleteCondition(() -> LocalPlayer.get().isAnimating())
                    .execute();
        }
        if (LocalPlayer.get().isAnimating())
            return ReactionGenerator.getPredictable();
        return ReactionGenerator.getPredictable();
    }
}

