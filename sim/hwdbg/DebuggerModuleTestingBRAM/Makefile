# Makefile

TOPLEVEL_LANG = verilog
VERILOG_SOURCES += $(shell pwd)/../../../generated/DebuggerModuleTestingBRAM.sv
VERILOG_SOURCES += $(shell pwd)/../../../generated/InitRegMemFromFile.sv
VERILOG_SOURCES += $(shell pwd)/../../../generated/DebuggerMain.sv
VERILOG_SOURCES += $(shell pwd)/../../../generated/SendReceiveSynchronizer.sv
VERILOG_SOURCES += $(shell pwd)/../../../generated/DebuggerPacketReceiver.sv
VERILOG_SOURCES += $(shell pwd)/../../../generated/DebuggerPacketSender.sv
TOPLEVEL = DebuggerModuleTestingBRAM
MODULE = test_DebuggerModuleTestingBRAM

include $(shell cocotb-config --makefiles)/Makefile.sim
