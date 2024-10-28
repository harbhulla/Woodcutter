import net.eternalclient.api.accessors.GameObjects;
import net.eternalclient.api.accessors.LocalPlayer;
import net.eternalclient.api.containers.Inventory;
import net.eternalclient.api.data.ItemID;
import net.eternalclient.api.internal.mouse.naturalmouse.api.*;
import net.eternalclient.api.internal.mouse.naturalmouse.support.DefaultMouseInfoAccessor;
import net.eternalclient.api.internal.mouse.naturalmouse.support.DefaultSpeedManager;
import net.eternalclient.api.internal.mouse.naturalmouse.support.Flow;
import net.eternalclient.api.internal.mouse.naturalmouse.support.MouseMotionNature;
import net.eternalclient.api.internal.mouse.naturalmouse.support.mousemotion.Movement;
import net.eternalclient.api.internal.mouse.naturalmouse.util.Pair;
import net.eternalclient.api.utilities.Log;
import net.eternalclient.api.events.EntityInteractEvent;
import net.eternalclient.api.events.InventoryEvent;
import net.eternalclient.api.frameworks.tree.Leaf;
import net.eternalclient.api.utilities.MethodProvider;
import net.eternalclient.api.utilities.ReactionGenerator;
import net.eternalclient.api.wrappers.input.Mouse;
import net.eternalclient.api.wrappers.interactives.GameObject;

import java.awt.*;

public class WoodcuttingLeaf extends Leaf
{
    @Override
    public boolean isValid()
    {
        return true;
    }

    @Override
    public int onLoop()
    {
        GameObject tree = GameObjects.closest(g -> g.hasName("Tree") && g.hasAction("Chop down"));
        if (tree == null)
        {
            MethodProvider.tickSleep(1);
            return ReactionGenerator.getLowPredictable();
        }

        if (!LocalPlayer.get().isAnimating() && new EntityInteractEvent(tree, "Chop down").executed())
        {
            MethodProvider.tickSleepUntil(() -> !LocalPlayer.get().isAnimating(), () -> LocalPlayer.get().isMoving(), 5);
        }
        return ReactionGenerator.getLowPredictable();
    }
}