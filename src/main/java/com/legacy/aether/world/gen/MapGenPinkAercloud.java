package com.legacy.aether.world.gen;

import java.util.Random;

import com.legacy.aether.world.gen.components.ComponentPinkAercloud;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenPinkAercloud extends MapGenStructure
{

    public MapGenPinkAercloud()
    {

    }

	@Override
	public String getStructureName()
	{
		return "aetherii:pink_aercloud";
	}

	@Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored)
    {
        this.world = worldIn;

        int j = pos.getX() >> 4;
        int k = pos.getZ() >> 4;

        for (int l = 0; l <= 1000; ++l)
        {
            for (int i1 = -l; i1 <= l; ++i1)
            {
                boolean flag = i1 == -l || i1 == l;

                for (int j1 = -l; j1 <= l; ++j1)
                {
                    boolean flag1 = j1 == -l || j1 == l;

                    if (flag || flag1)
                    {
                        int k1 = j + i1;
                        int l1 = k + j1;

                        if (this.canSpawnStructureAtCoords(k1, l1) && (!findUnexplored || !worldIn.isChunkGeneratedAt(k1, l1)))
                        {
                            return new BlockPos((k1 << 4) + 8, 64, (l1 << 4) + 8);
                        }
                    }
                }
            }
        }

        return null;
    }

	@Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
		return this.rand.nextInt(70) == 0;
    }

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) 
	{
		return new Start(this.world, this.rand, chunkX, chunkZ);
	}

    public static class Start extends StructureStart
    {
        public Start()
        {

        }

        public Start(World worldIn, Random random, int chunkX, int chunkZ)
        {
            super(chunkX, chunkZ);

            this.create(worldIn, random, chunkX, chunkZ);
        }

        private void create(World worldIn, Random random, int chunkX, int chunkZ)
        {
            this.components.add(new ComponentPinkAercloud(random, (chunkX << 4) + 2, random.nextInt(30) + 110, (chunkZ << 4) + 2));

            this.updateBoundingBox();
        }

    }
}