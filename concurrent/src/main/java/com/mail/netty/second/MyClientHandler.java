package com.mail.netty.second;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("{} {}", ctx.channel().remoteAddress(), msg);
        ctx.writeAndFlush("from client:" + LocalDate.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush("来自于客户端的问候");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
