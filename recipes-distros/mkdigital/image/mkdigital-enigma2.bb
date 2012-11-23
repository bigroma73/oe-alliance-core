DESCRIPTION = "Merge machine and distro options to create a enigma2 machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "1.0"
PR = "r0"

inherit task

DEPENDS = ""

RRECOMMENDS = "\
	\
	${@base_contains("MACHINE_FEATURES", "3dtv", "enigma2-plugin-systemplugins-osd3dsetup" , "", d)} \
	"
