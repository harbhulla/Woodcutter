import net.eternalclient.api.accessors.LocalPlayer;
import net.eternalclient.api.frameworks.tree.Leaf;
import net.eternalclient.api.utilities.Log;
import net.eternalclient.api.utilities.ReactionGenerator;
import net.eternalclient.api.wrappers.map.RectArea;
import net.eternalclient.api.wrappers.walking.Walking;

import java.util.List;

public class TraversingLeaf extends Leaf {

    @Override
    public boolean isValid() {
       return !LocalPlayer.get().isInArea(new RectArea(3200,3505,3224,3502));
    }

    @Override
    public int onLoop() {
        List<Tree> usableTrees = Tree.getUsable(); // Fetches trees based on the player’s level

        if (!usableTrees.isEmpty()) {
            Tree targetTree = Tree.getRandomHighestLevelTree();// Chooses a random tree with the highest level
            Log.info(targetTree.getPosition().toString());
            if (targetTree != null) {
                Walking.walk(targetTree.getPosition()); // Walks to the selected tree’s position
                Log.info("Walking to " + targetTree.getName() + " at " + targetTree.getPosition());
                return ReactionGenerator.getPredictable();
            }
        } else {
            Log.info("No usable trees found for current level.");
        }

        return ReactionGenerator.getPredictable();
    }
}


