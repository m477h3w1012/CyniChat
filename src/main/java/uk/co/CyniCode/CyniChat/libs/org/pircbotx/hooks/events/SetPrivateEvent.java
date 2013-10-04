/**
 * Copyright (C) 2010-2013 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PircBotX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PircBotX. If not, see <http://www.gnu.org/licenses/>.
 */
package uk.co.CyniCode.CyniChat.libs.org.pircbotx.hooks.events;

import uk.co.CyniCode.CyniChat.libs.org.pircbotx.Channel;
import uk.co.CyniCode.CyniChat.libs.org.pircbotx.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.co.CyniCode.CyniChat.libs.org.pircbotx.hooks.Event;
import uk.co.CyniCode.CyniChat.libs.org.pircbotx.PircBotX;
import uk.co.CyniCode.CyniChat.libs.org.pircbotx.hooks.types.GenericChannelModeEvent;

/**
 * Called when a channel is marked as being in private mode.
 * <p>
 * This is a type of mode change and therefor is also dispatched in a
 * {@link uk.co.CyniCode.CyniChat.libs.org.pircbotx.hooks.events.ModeEvent}
 * @author Leon Blakey <lord.quackstar at gmail.com>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SetPrivateEvent<T extends PircBotX> extends Event<T> implements GenericChannelModeEvent<T> {
	protected final Channel channel;
	protected final User user;

	/**
	 * Default constructor to setup object. Timestamp is automatically set
	 * to current time as reported by {@link System#currentTimeMillis() }
	 * @param channel The channel in which the mode change took place.
	 * @param user The user that performed the mode change.
	 */
	public SetPrivateEvent(T bot, Channel channel, User user) {
		super(bot);
		this.channel = channel;
		this.user = user;
	}

	/**
	 * Respond by send a message in the channel to the user that set the mode
	 * in
	 * <code>user: message</code> format
	 * @param response The response to send
	 */
	@Override
	public void respond(String response) {
		getBot().sendMessage(getChannel(), getUser(), response);
	}
}