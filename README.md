# LagPageGenerator - WebGenerator
###(c) Jan-Ivar B&oslash;yum    2024 -

This is a simple web page generator that generates a web page for a team in most team sports. The site is built up by a header with the club's logo, name and team name. A team picture and general description of the team can be entered. In addition, you can enter information about training places and time, coaches/managers and then more. There are two versions simple and advanced. In the advanced version you can register players on the team with picture, name and player position. Pictures of coaches/managers can also be posted here. All information about club (logo, name etc.) and standard fields as standard headings are configurable.

## SETUP
Web generator is configured with "config.properties" file under file directory "config". This file can be configured as follows:

<center><table width="80%">
	<tr>
		<td width="20%">hometext</td>
		<td Width="40%">Menu Text for Home</td>
		<td>Typical Eng.: HOME</td>
	</tr>
	<tr>
		<td width="20%">homepage</td>
		<td Width="40%">URL for homepage</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">infotext</td>
		<td Width="40%">Menu text for internal link to team information</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">clubname</td>
		<td Width="40%">The name of the sports club</td>
		<td></td>
	</tr>
	<tr>
		<td width="15%">clublogo</td>
		<td Width="40%">Logo to sports club</td>
		<td>This should be stored under the application file directory: "html/image"</td>
	</tr>
	<tr>
		<td width="15%">traininghead</td>
		<td Width="40%">Heading for training place and time section of the web page</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">leaderhead</td>
		<td Width="40%">Heading for the coach/manager section of the web page</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">playerhead</td>
		<td Width="40%">Heading for the player's section of the web page</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">leaderA</td>
		<td Width="40%">Prompt: leader A</td>
		<td>Only used on simple page.</td>
	</tr>
	<tr>
		<td width="20%">leaderB</td>
		<td Width="40%">Prompt: leader B</td>
		<td>Only used on simple page.</td>
	</tr>
	<tr>
		<td width="20%">leaderC</td>
		<td Width="40%">Prompt: leader C</td>
		<td>Only used on simple page.</td>
	</tr>
	<tr>
		<td width="20%">leaderD</td>
		<td Width="40%">Prompt: leader D</td>
		<td>Only used on simple page.</td>
	</tr>
	<tr>
		<td width="20%">leaderE</td>
		<td Width="40%">Prompt: leader E</td>
		<td>Only used on simple page.</td>
	</tr>
</table></center>

## Installation
WebGenerator must be installed in a suitable file directory. As sub-directories to this file directory, you must have 4 file directories. These must have the following names: bin, work, config and html. File directory html must also have a sub-directory named: image. The top directory should contain the startup file, the config directory should contain the config file and the bin file should contain the JAR file. The other two directories are used during execution.

WebGenerator is developed in Java/Swing and is built as a JAR file with included libraries.

It is recommended to read the document "Webgen.pdf" to see exactly how to install.

## Use of the application.
Using the application itself is very easy. Basically, just record data and generate. However, it is recommended to read the document "Webgen.pdf" to see rules for images and the like.

## Licence
This source code is licensed under : [GNU General Public License v3.0
(GPL-3.0)](https://www.gnu.org/licenses/gpl-3.0.html) 

