#include <config.h>

#include "memxor.h"

void *
memxor (void *dest, const void *src, size_t n)
{
  char const *s = src;
  char *d = dest;

  for (; n > 0; n--)
    *d++ ^= *s++;

  return dest;
}
