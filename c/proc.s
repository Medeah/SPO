	.file	"proc.c"
	.section	.text.unlikely,"ax",@progbits
.LCOLDB0:
	.text
.LHOTB0:
	.p2align 4,,15
	.globl	proc
	.type	proc, @function
proc:
.LFB39:
	.cfi_startproc
	movq	%rdi, %rax
	andl	$15, %eax
	shrq	$2, %rax
	negq	%rax
	andl	$3, %eax
	je	.L9
	cmpl	$1, %eax
	movl	(%rdi), %esi
	je	.L10
	addl	4(%rdi), %esi
	cmpl	$3, %eax
	jne	.L11
	addl	8(%rdi), %esi
	movl	$399999997, %r9d
	movl	$3, %r8d
.L3:
	movl	$400000000, %r10d
	movl	%eax, %edx
	movl	$399999996, %r11d
	subl	%eax, %r10d
	movl	$99999999, %ecx
.L2:
	pxor	%xmm0, %xmm0
	leaq	(%rdi,%rdx,4), %rdx
	xorl	%eax, %eax
	.p2align 4,,10
	.p2align 3
.L4:
	addl	$1, %eax
	paddd	(%rdx), %xmm0
	addq	$16, %rdx
	cmpl	%eax, %ecx
	ja	.L4
	movdqa	%xmm0, %xmm1
	movl	%r9d, %ecx
	subl	%r11d, %ecx
	leal	(%r8,%r11), %edx
	psrldq	$8, %xmm1
	paddd	%xmm1, %xmm0
	movdqa	%xmm0, %xmm1
	psrldq	$4, %xmm1
	paddd	%xmm1, %xmm0
	movd	%xmm0, %eax
	addl	%esi, %eax
	cmpl	%r11d, %r10d
	je	.L7
	movslq	%edx, %rsi
	addl	(%rdi,%rsi,4), %eax
	cmpl	$1, %ecx
	leal	1(%rdx), %esi
	je	.L7
	movslq	%esi, %rsi
	addl	$2, %edx
	addl	(%rdi,%rsi,4), %eax
	cmpl	$2, %ecx
	je	.L7
	movslq	%edx, %rdx
	addl	(%rdi,%rdx,4), %eax
	ret
	.p2align 4,,10
	.p2align 3
.L7:
	rep ret
	.p2align 4,,10
	.p2align 3
.L9:
	movl	$400000000, %r11d
	movl	$100000000, %ecx
	movl	$400000000, %r10d
	xorl	%edx, %edx
	movl	$400000000, %r9d
	xorl	%r8d, %r8d
	xorl	%esi, %esi
	jmp	.L2
	.p2align 4,,10
	.p2align 3
.L11:
	movl	$399999998, %r9d
	movl	$2, %r8d
	jmp	.L3
	.p2align 4,,10
	.p2align 3
.L10:
	movl	$399999999, %r9d
	movl	$1, %r8d
	jmp	.L3
	.cfi_endproc
.LFE39:
	.size	proc, .-proc
	.section	.text.unlikely
.LCOLDE0:
	.text
.LHOTE0:
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC1:
	.string	"hello"
.LC4:
	.string	"start timer"
.LC5:
	.string	"end timer"
.LC7:
	.string	"Time: %f\n"
.LC8:
	.string	"Res: %d\n"
	.section	.text.unlikely
.LCOLDB9:
	.section	.text.startup,"ax",@progbits
.LHOTB9:
	.p2align 4,,15
	.globl	main
	.type	main, @function
main:
.LFB40:
	.cfi_startproc
	pushq	%r12
	.cfi_def_cfa_offset 16
	.cfi_offset 12, -16
	pushq	%rbp
	.cfi_def_cfa_offset 24
	.cfi_offset 6, -24
	movl	$.LC1, %edi
	pushq	%rbx
	.cfi_def_cfa_offset 32
	.cfi_offset 3, -32
	subq	$16, %rsp
	.cfi_def_cfa_offset 48
	call	puts
	movl	$1600000000, %edi
	call	malloc
	movq	%rax, %rbp
	movq	%rax, %r12
	andl	$15, %ebp
	shrq	$2, %rbp
	negq	%rbp
	andl	$3, %ebp
	je	.L33
	cmpl	$1, %ebp
	movl	$0, (%rax)
	je	.L34
	cmpl	$3, %ebp
	movl	$1, 4(%rax)
	jne	.L35
	movl	$2, 8(%rax)
	movl	$399999997, %edi
	movl	$3, %eax
.L21:
	movl	$400000000, %r8d
	movl	%ebp, %edx
	movl	$399999996, %r9d
	subl	%ebp, %r8d
	movl	$99999999, %esi
.L20:
	movl	%eax, 12(%rsp)
	leaq	(%r12,%rdx,4), %rcx
	xorl	%edx, %edx
	movd	12(%rsp), %xmm2
	movdqa	.LC3(%rip), %xmm1
	pshufd	$0, %xmm2, %xmm0
	paddd	.LC2(%rip), %xmm0
	.p2align 4,,10
	.p2align 3
.L22:
	addl	$1, %edx
	addq	$16, %rcx
	movaps	%xmm0, -16(%rcx)
	paddd	%xmm1, %xmm0
	cmpl	%esi, %edx
	jb	.L22
	addl	%r9d, %eax
	subl	%r9d, %edi
	cmpl	%r9d, %r8d
	je	.L24
	movslq	%eax, %rcx
	cmpl	$1, %edi
	movl	%eax, (%r12,%rcx,4)
	leal	1(%rax), %ecx
	je	.L24
	movslq	%ecx, %rsi
	addl	$2, %eax
	cmpl	$2, %edi
	movl	%ecx, (%r12,%rsi,4)
	je	.L24
	movslq	%eax, %rdx
	movl	%eax, (%r12,%rdx,4)
.L24:
	movl	$.LC4, %edi
	call	puts
	call	clock
	testl	%ebp, %ebp
	movq	%rax, %rbx
	je	.L36
	cmpl	$1, %ebp
	movl	(%r12), %edi
	jbe	.L37
	addl	4(%r12), %edi
	cmpl	$3, %ebp
	jne	.L38
	addl	8(%r12), %edi
	movl	$399999997, %r9d
	movl	$3, %eax
.L27:
	movl	$399999996, %esi
	movl	$400000000, %r8d
	movl	%ebp, %edx
	subl	%ebp, %esi
	subl	%ebp, %r8d
	shrl	$2, %esi
	addl	$1, %esi
	leal	0(,%rsi,4), %r10d
.L26:
	pxor	%xmm0, %xmm0
	leaq	(%r12,%rdx,4), %rcx
	xorl	%edx, %edx
	.p2align 4,,10
	.p2align 3
.L28:
	addl	$1, %edx
	paddd	(%rcx), %xmm0
	addq	$16, %rcx
	cmpl	%edx, %esi
	ja	.L28
	movdqa	%xmm0, %xmm1
	movl	%r9d, %edx
	addl	%r10d, %eax
	subl	%r10d, %edx
	psrldq	$8, %xmm1
	paddd	%xmm1, %xmm0
	movdqa	%xmm0, %xmm1
	psrldq	$4, %xmm1
	paddd	%xmm1, %xmm0
	movd	%xmm0, %ebp
	addl	%edi, %ebp
	cmpl	%r10d, %r8d
	je	.L31
	movslq	%eax, %rcx
	addl	(%r12,%rcx,4), %ebp
	cmpl	$1, %edx
	leal	1(%rax), %ecx
	je	.L31
	movslq	%ecx, %rcx
	addl	$2, %eax
	addl	(%r12,%rcx,4), %ebp
	cmpl	$2, %edx
	je	.L31
	cltq
	addl	(%r12,%rax,4), %ebp
.L31:
	call	clock
	movl	$.LC5, %edi
	movq	%rax, %r12
	call	puts
	pxor	%xmm0, %xmm0
	subq	%rbx, %r12
	movl	$.LC7, %esi
	movl	$1, %edi
	movl	$1, %eax
	cvtsi2sdq	%r12, %xmm0
	divsd	.LC6(%rip), %xmm0
	call	__printf_chk
	addq	$16, %rsp
	.cfi_remember_state
	.cfi_def_cfa_offset 32
	movl	%ebp, %edx
	movl	$.LC8, %esi
	popq	%rbx
	.cfi_def_cfa_offset 24
	popq	%rbp
	.cfi_def_cfa_offset 16
	popq	%r12
	.cfi_def_cfa_offset 8
	movl	$1, %edi
	xorl	%eax, %eax
	jmp	__printf_chk
.L36:
	.cfi_restore_state
	movl	$400000000, %r10d
	movl	$100000000, %esi
	movl	$400000000, %r8d
	xorl	%edx, %edx
	movl	$400000000, %r9d
	xorl	%edi, %edi
	xorl	%eax, %eax
	jmp	.L26
.L33:
	movl	$400000000, %r9d
	movl	$100000000, %esi
	movl	$400000000, %r8d
	xorl	%edx, %edx
	movl	$400000000, %edi
	xorl	%eax, %eax
	jmp	.L20
.L35:
	movl	$399999998, %edi
	movl	$2, %eax
	jmp	.L21
.L37:
	movl	$399999999, %r9d
	movl	$1, %eax
	jmp	.L27
.L38:
	movl	$399999998, %r9d
	movl	$2, %eax
	jmp	.L27
.L34:
	movl	$399999999, %edi
	movl	$1, %eax
	jmp	.L21
	.cfi_endproc
.LFE40:
	.size	main, .-main
	.section	.text.unlikely
.LCOLDE9:
	.section	.text.startup
.LHOTE9:
	.section	.rodata.cst16,"aM",@progbits,16
	.align 16
.LC2:
	.long	0
	.long	1
	.long	2
	.long	3
	.align 16
.LC3:
	.long	4
	.long	4
	.long	4
	.long	4
	.section	.rodata.cst8,"aM",@progbits,8
	.align 8
.LC6:
	.long	0
	.long	1093567616
	.ident	"GCC: (Ubuntu 4.9.1-16ubuntu6) 4.9.1"
	.section	.note.GNU-stack,"",@progbits
