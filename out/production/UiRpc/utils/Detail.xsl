<?xml version="1.0" encoding="UTF-8"?>
<!-- This file is for testcase detail xml-->
<!DOCTYPE xsl:stylesheet [ <!ENTITY nbsp "&#160;"> ]>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output version="1.0" indent="yes" encoding="GB2312" method="html"/>
    <xsl:template match="/">
        <html>
 			<body topmargin="0">
				<table id="Table_01" width="100%" height="49" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th>NO</th>
						<th>Result</th>
						<th>SnapShot</th>
						<th>Log</th>
					</tr>
					<xsl:for-each select="TestCaseDetail/TestCase">
					<tr>
						<td><xsl:value-of select="NO"/></td>
						<td><xsl:variable name="result" select="Result">
							</xsl:variable>
							<xsl:choose>
								<xsl:when test="$result='true'">
									Passed
								</xsl:when>
								<xsl:when test="$result='false'">
									Failed
								</xsl:when>
								<xsl:otherwise>
									获取testcase执行结果失败
								</xsl:otherwise>
							</xsl:choose>
						</td>
						<td>
							<xsl:variable name="Shot" select="SnapShot">
							</xsl:variable>
							<xsl:choose>
								<xsl:when test="$Shot='NONE'">
									无截图
								</xsl:when>
								<xsl:otherwise>
									<a>
										<xsl:attribute name="href"><xsl:value-of select="SnapShot"/></xsl:attribute>
										<img width="90" height="160">
											<xsl:attribute name="src"><xsl:value-of select="SnapShot"/></xsl:attribute>
										</img>	
									</a>
								</xsl:otherwise>
							</xsl:choose>
						</td>
						<td bgcolor="#FFFF00">
							<xsl:variable name="hyperlink">
								<xsl:value-of select="Log"/>
							</xsl:variable>
							<a href="{$hyperlink}">
								<xsl:value-of select="Log"/>
							</a>
						</td>
					</tr>
					</xsl:for-each>
                </table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>	
				
