PRINC = "5"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += " \
	file://init \
"

SRC_URI_append_gbquad= " \
	file://udev-builtin-input_id.patch \
"

SRC_URI_append_dm800= " \
	file://udev-builtin-input_id.patch \
"

SRC_URI_append_ventonhde= " \
	file://udev-builtin-input_id.patch \
"
inherit update-rc.d

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 03 S ."

do_install_append () {
	rm ${D}${sysconfdir}/udev/rules.d/*.rules || /bin/true
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
