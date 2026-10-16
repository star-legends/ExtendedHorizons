package me.mapacheee.extendedhorizons.fakechunks.backend;

import com.thewinterframework.service.annotation.expose.Expose;
import io.netty.buffer.ByteBuf;
import org.bukkit.World;

import java.util.concurrent.CompletableFuture;

@Expose
public interface ChunkBackend {

  @FunctionalInterface
  interface ChunkScheduler {
    boolean runAtChunk(World world, int chunkX, int chunkZ, Runnable runnable);
  }

  CompletableFuture<ByteBuf> buildChunkPayload(
    World world,
    int chunkX,
    int chunkZ,
    boolean generateMissingChunks,
    ChunkScheduler scheduler
  );

  default CompletableFuture<ByteBuf> buildChunkPayload(
    World world,
    int chunkX,
    int chunkZ,
    boolean generateMissingChunks,
    boolean preferFreshData,
    ChunkScheduler scheduler
  ) {
    return this.buildChunkPayload(world, chunkX, chunkZ, generateMissingChunks, scheduler);
  }
}
