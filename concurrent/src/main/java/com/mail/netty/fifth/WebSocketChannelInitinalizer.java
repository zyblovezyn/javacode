package com.mail.netty.fifth;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitinalizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline=ch.pipeline();

        pipeline.addLast("httpcodex",new HttpServerCodec());

        pipeline.addLast(new ChunkedWriteHandler());

        // 把数据包聚合到一起
        pipeline.addLast(new HttpObjectAggregator(8192));

        pipeline.addLast(new WebSocketServerProtocolHandler("ws"));

        pipeline.addLast(new TestWebSocketFrameHandler());
    }
}
