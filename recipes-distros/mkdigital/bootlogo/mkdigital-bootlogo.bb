DESCRIPTION = "MK-Digital bootlogo"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "MK-Digital"

require conf/license/license-gplv2.inc

RDEPENDS_${PN} += "showiframe"

PV = "1.0"
PR = "r0"

S = "${WORKDIR}"

INITSCRIPT_NAME = "bootlogo"
INITSCRIPT_PARAMS = "start 05 S ."

inherit update-rc.d

SRC_URI = "file://bootlogo.mvi file://bootlogo.sh"


MVISYMLINKS = "bootlogo_wait backdrop switchoff"

do_install() {
	install -d ${D}/boot
	install -d ${D}/usr/share
	install -m 0755 bootlogo.mvi ${D}/usr/share/bootlogo.mvi
	ln -sf /usr/share/bootlogo.mvi ${D}/boot/bootlogo.mvi
	for i in ${MVISYMLINKS}; do
		ln -sf /boot/bootlogo.mvi ${D}/boot/$i.mvi
		ln -sf /usr/share/bootlogo.mvi ${D}/usr/share/$i.mvi;
	done;
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${S}/bootlogo.sh ${D}/${sysconfdir}/init.d/bootlogo
}

pkg_preinst() {
	[ -d /proc/stb ] && mount -t jffs2 mtd:'boot partition' /boot
	true
}

pkg_postinst() {
	[ -d /proc/stb ] && umount /boot
	true
}

pkg_prerm() {
	[ -d /proc/stb ] && mount -t jffs2 mtd:'boot partition' /boot
	true
}

pkg_postrm() {
	[ -d /proc/stb ] && umount /boot
	true
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share /etc/init.d"
